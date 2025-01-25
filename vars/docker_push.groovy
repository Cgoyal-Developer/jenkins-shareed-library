// Define the function to push Docker image to Docker Hub
def docker_push(String project, String imageTag, String dockerhubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        sh "docker login -u ${dockerhubUser} -p ${dockerHubPass}"
    }
    sh "docker push ${dockerhubUser}/${project}:${imageTag}"
}
