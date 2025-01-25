def scanDockerImage(imageName) {
    // Run Trivy scan for Docker image in human-readable format
    sh """
    trivy image --format table --severity HIGH,CRITICAL --exit-code 1 ${imageName}
    """
}
