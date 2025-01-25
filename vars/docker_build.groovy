// Define the function to build Docker image
def docker_build(String projectName, String imageTag, String dockerHubUser) {
    echo "Building Docker image: ${dockerHubUser}/${projectName}:${imageTag}"
    sh """
        docker build -t ${dockerHubUser}/${projectName}:${imageTag} .
    """
}
