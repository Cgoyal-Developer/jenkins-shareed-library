def scanDockerImage(imageName) {
    // Check if Docker is running with the right permissions
    try {
        // Running the Trivy scan in a human-readable format with elevated permissions
        echo "Running Trivy scan for image ${imageName}"
        sh """
        docker info > /dev/null || (echo 'Docker daemon is not running' && exit 1)
        trivy image --format table --severity HIGH,CRITICAL --exit-code 1 ${imageName}
        """
    } catch (Exception e) {
        error "Error scanning Docker image: ${e.getMessage()}"
    }
}
