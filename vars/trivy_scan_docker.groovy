def call(FS_VULN_FILE) {
    try {
        // Run the Trivy filesystem scan and save output to a file
        echo "Running Trivy filesystem scan"
        def result = sh(script: """
            trivy fs --format table --severity HIGH,CRITICAL --exit-code 0 --no-progress . > ${FS_VULN_FILE}
        """, returnStatus: true)
        
        // If vulnerabilities are found (exit code 0, but vulnerabilities exist), log to a file
        if (result == 0) {
            echo "Filesystem vulnerabilities found, report saved to ${FS_VULN_FILE}"
            return true // Return true indicating vulnerabilities were found
        } else {
            echo "No high or critical filesystem vulnerabilities found."
            return false // Return false indicating no vulnerabilities
        }
    } catch (Exception e) {
        echo "Error during filesystem scan: ${e.getMessage()}"
        return true // Assume vulnerabilities found if an error occurs
    }
}
