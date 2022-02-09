pipeline {
     agent any
     stages {
            stage('Build') {
                steps {
                    bat 'mvn clean verify'
                }
            }
     }
     deploy adapters: [tomcat9(credentialsId: 'f15b4851-a0d2-4a0d-aa02-42316ed80bd4', path: '', url: 'http://localhost:1111/')], contextPath: 'greeting', war: 'greeting.war'
}