node {
    def repourl = "${REGISTRY_URL}/${PROJECT_ID}/${ARTIFACT_REGISTRY}"
    def mvnHome = tool name: 'maven', type: 'maven'
    def mvnCMD = "${mvnHome}/bin/mvn "
    stage('checkout') {
            checkout([$class: 'GitSCM',
            branches: [[name: '*/main']],
            extensions: [],
            userRemoteConfigs: [[credentialsId: 'git', url: 'https://github.com/abhisekB9/search-service.git']]])
    }
    stage('Build') {
        sh "${mvnCMD} clean install"
    }
    stage('SonarQube analysis') {
        withSonarQubeEnv('Sonar') {
            sh "${mvnCMD} sonar:sonar"
        }
    }
    stage('Quality gate') {
        waitForQualityGate abortPipeline: true
    }
    stage('Push Image') {
        withCredentials([file(credentialsId: 'gcp', variable: 'GC_KEY')]) {
            sh("gcloud auth activate-service-account --key-file=${GC_KEY}")
            sh 'gcloud auth configure-docker  asia-south1-docker.pkg.dev'
            sh "${mvnCMD} jib:build -DREPO_URL=${REGISTRY_URL}/${PROJECT_ID}/${ARTIFACT_REGISTRY}"
        }
    }
    stage('Deploy') {
        sh "sed -i 's|IMAGE_URL|${repourl}|g' k8s/deployment.yaml"
        step([$class: 'KubernetesEngineBuilder',
            projectId: env.PROJECT_ID,
            clusterName: env.CLUSTER,
            location: env.ZONE,
            manifestPattern: 'k8s/deployment.yaml',
            credentialsId: env.PROJECT_ID,
            verifyDeployments: true])
    }
}