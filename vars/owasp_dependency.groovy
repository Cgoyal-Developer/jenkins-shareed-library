def call() {
    // Run the Dependency-Check scan with necessary arguments
    dependencyCheck additionalArguments: '--scan ./ --out ./dependency-check-reports --format XML', odcInstallation: 'OWASP'

    // Publish the Dependency-Check results
    dependencyCheckPublisher pattern: '**/dependency-check-reports/dependency-check-report.xml'
}
