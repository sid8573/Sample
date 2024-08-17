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
                sh 'gradle clean build'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'gradle test'
            }
            post {
                always {
                    junit '**/target/test-reports/*.xml'
                }
            }
        }

        stage('Send Email Report') {
            steps {
                emailext(
                    subject: 'Test Report',
                    body: 'Attached is the test report from the latest build.',
                    to: 'lookingfor7lpa@gmail.com',
                    attachmentsPattern: '**/target/test-reports/*.xml'
                )
            }
        }
    }
}
