def cicdPipeline(List environments) {

    pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    script {
                        buildApp.checkoutCode()
                    }
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
                    for (String env : environments) {
                        stage(env) {
                            steps {
                                script {
                                    buildApp.deployToEnvironment(env)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
