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
        }

        stage('Send Email Report') {
            steps {
                emailext(
                    subject: 'Test Report',
                    body: 'Successful run',
                    to: 'lookingfor7lpa@gmail.com'
                )
            }
        }
    }
}
