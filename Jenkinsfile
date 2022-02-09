pipeline {
     agent any
     stages {
            stage('Build') {
                steps {
                    bat 'mvn clean verify'
                }
            }
            stage('Deploy') {
                            steps {
                                deploy adapters: [tomcat9(credentialsId: '6d935eb5-53e9-4644-9954-608dfc97a2e3', path: '', url: 'http://localhost:1111/')], contextPath: 'greeting', war: 'target/greeting.war'
                            }
                        }
     }





}