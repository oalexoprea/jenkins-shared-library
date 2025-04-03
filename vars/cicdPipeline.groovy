def cicdPipeline() {
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
                    script {
                        buildApp.build()
                    }
                }
            }
            stage('Test') {
                steps {
                    echo 'Running tests...'
                    // Add test steps here
                }
            }
            stage('Package') {
                steps {
                    echo 'Packaging the application...'
                    // Add package steps here
                }
            }
            stage('Deploy') {
                stages {
                    stage('Dev') {
                        steps {
                            echo 'Deploying to Dev environment...'
                            // Add deploy to dev steps here
                        }
                    }
                    stage('Staging') {
                        steps {
                            echo 'Deploying to Staging environment...'
                            // Add deploy to staging steps here
                        }
                    }
                    stage('Production') {
                        steps {
                            echo 'Deploying to Production environment...'
                            // Add deploy to production steps here
                        }
                    }
                }
            }
        }
    }
}
