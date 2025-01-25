// vars/scanDockerImage.groovy

def call(imageName, VULN_FILE) {
    try {
        // Run the Trivy scan for vulnerabilities and save output to a file
        echo "Running Trivy scan for image ${imageName}"
        def result = sh(script: """
            trivy image --format table --severity HIGH,CRITICAL --exit-code 0 --no-progress ${imageName} > ${VULN_FILE}
        """, returnStatus: true)
        
        // If vulnerabilities are found (exit code 0, but vulnerabilities exist), log to a file
        if (result == 0) {
            echo "Vulnerabilities found, report saved to ${VULN_FILE}"
            return true // Return true indicating vulnerabilities were found
        } else {
            echo "No high or critical vulnerabilities found."
            return false // Return false indicating no vulnerabilities
        }
    } catch (Exception e) {
        echo "Error during Trivy scan: ${e.getMessage()}"
        return true // Assume vulnerabilities found if an error occurs
    }
}
