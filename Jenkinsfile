pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/akshitrajpatel/ToDoAppSeleniumTest.git'
                
                // Build the Maven project
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run Selenium tests
                bat 'mvn test'
            }
        }
    }
    
    post {
        always {
            // Archive the test results
            junit '**/target/surefire-reports/*.xml'
        }
        
        success {
            echo 'Build and tests succeeded!'
        }
        
        failure {
            echo 'Build or tests failed.'
        }
    }
}
