pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'gradle clean build'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'gradle test'
            }
            post {
                always {
                    junit '**/build/reports/tests/test/*.html'
                }
            }
        }

        stage('Send Email Report') {
            steps {
                emailext(
                    subject: 'Test Report',
                    body: 'Attached is the test report from the latest build.',
                    to: 'lookingfor7lpa@gmail.com',
                    attachmentsPattern: '**/build/reports/tests/test/*.html'
                )
            }
        }
    }
}
