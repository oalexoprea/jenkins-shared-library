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
                    script {
                        buildApp.test()
                    }
                }
            }
            stage('Package') {
                steps {
                    script {
                        buildApp.packageApp()
                    }
                }
            }
            stage('Deploy') {
                stages {
                    stage('Dev') {
                        steps {
                            script {
                                buildApp.deployDev()
                            }
                        }
                    }
                    stage('Staging') {
                        steps {
                            script {
                                buildApp.deployStaging()
                            }
                        }
                    }
                    stage('Production') {
                        steps {
                            script {
                                buildApp.deployProd()
                            }
                        }
                    }
                }
            }
        }
    }
}
