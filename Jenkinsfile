pipeline {
     agent any
     stages {
            stage('Build, Test') {
                            when {
                                not {
                                    branch 'main'
                                }
                            }
                            steps {
                                bat 'mvn clean verify'
                            }
                        }

            stage('Build, Test, Release'){
                            when {
                                branch 'main'
                            }
                            steps {
                                rtMavenDeployer (
                                    id: 'artifactory',
                                    serverId: 'artifactory',
                                    releaseRepo: 'maven-libs-release-local',
                                    snapshotRepo: 'maven-libs-snapshot-local'
                                )

                                rtMavenRun (
                                    tool: 'Maven 3.6.3',
                                    pom: 'pom.xml',
                                    goals: 'clean install',
                                    deployerId: 'randomname',
                                )
                            }
                        }

            stage('Deploy') {
            when {
            branch 'main'
            }
                            steps {
                                deploy adapters: [tomcat9(
                                credentialsId: '6d935eb5-53e9-4644-9954-608dfc97a2e3',
                                 path: '',
                                 url: 'http://localhost:1111/')],
                                  contextPath: 'greeting',
                                  war: 'target/greeting.war'
                            }
                        }
     }

}