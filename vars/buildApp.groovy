def checkoutCode() {
    checkout scm
}

def build() {
    echo "Building application..."
    // Add actual build steps here, e.g., npm install, mvn clean install, etc.
}

def test() {
    echo "Running tests..."
    // Add actual test steps here, e.g., npm test, pytest, etc.
}

def packageApp() {
    echo "Packaging application..."
    // Add actual package steps here, e.g., docker build, jar, zip, etc.
}

def deployToEnvironment(String environment, Map deploymentConfig) {
    echo "Deploying to ${environment} environment..."
    if (environment == 'Dev') {
        echo "Deploying to Dev server: ${deploymentConfig.devServer}"
        // Dev deployment steps using deploymentConfig.devServer
    } else if (environment == 'Staging') {
        echo "Deploying to Staging server: ${deploymentConfig.stagingServer}"
        // Staging deployment steps using deploymentConfig.stagingServer
    } else if (environment == 'Production') {
        echo "Deploying to Production server: ${deploymentConfig.prodServer}"
        // Production deployment steps using deploymentConfig.prodServer
    } else {
        echo "Unknown environment: ${environment}"
    }
}
