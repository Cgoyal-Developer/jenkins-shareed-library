def trivy_scan() {
    // Define the file name for the vulnerability report
    def vulnFile = 'vuln_scan.txt'

    // Run Trivy scan on the current directory in table format and output to vuln_scan.txt
    sh "trivy fs . --format table --output ${vulnFile}"

    // Ensure that the file permissions allow access (chmod 777)
    sh "chmod 777 ${vulnFile}"

    // Check if the vulnerability report exists and archive it
    if (fileExists(vulnFile)) {
        archiveArtifacts artifacts: vulnFile, allowEmptyArchive: true
    } else {
        echo "No vulnerabilities found or scan failed. Skipping archiving."
    }
    
    // Optionally, clean up the workspace after scan (remove the report if not needed)
    // cleanWs()
}
