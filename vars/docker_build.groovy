// Define the function to build Docker image
def docker_build(String imageTag, String dockerHubUser) {
    sh """
        docker build -t ${dockerHubUser}/${projectName}:${imageTag} .
    """
}
