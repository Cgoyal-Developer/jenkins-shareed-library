def trivy_scan() {
    // Run Trivy scan on the current directory
    sh "trivy fs . --format plain --output trivy_scan_results.txt"
    
    // Archive the results file to make it available in Jenkins UI
    archiveArtifacts artifacts: 'trivy_scan_results.txt', allowEmptyArchive: true
}
