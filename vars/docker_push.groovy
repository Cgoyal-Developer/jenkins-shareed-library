// Define the function to push Docker image to Docker Hub
def docker_push(String project, String imageTag, String dockerHubUser) {
    echo "Pushing Docker image: ${dockerHubUser}/${project}:${imageTag}"
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    }
    sh "docker push ${dockerHubUser}/${project}:${imageTag}"
}
