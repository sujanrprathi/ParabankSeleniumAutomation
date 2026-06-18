pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sujanrprathi/parabank-automation.git'
            }
        }

        stage('Build & Test (Headless)') {
            steps {
                sh 'mvn clean test -Dheadless=true'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/reports',
                    reportFiles: 'extentReport_*.html',
                    reportName: 'ParaBank Automation Report'
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/reports/screenshots/*.png', allowEmptyArchive: true
        }
    }
}