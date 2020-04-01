#!groovy

pipeline {
    agent any

    options {
            buildDiscarder(logRotator(numToKeepStr: '15', artifactNumToKeepStr: '15'))
    }

    stages {
        stage("TEST RUN") {
            steps {
                script {
                     sh './gradlew clean test --tests TestAlluerPlugin'
                }
            }
        }

        stage('MAKING TEST RESULT') {
            steps {
                script {
                    sh 'pwd'
                }
            }
        }
    }
    post {
        always {
            script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'build/allure-results']]
                ])
            }
            cleanWs()
        }
    }
}