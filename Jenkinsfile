pipeline {
agent any

tools {
maven "maven 3.6.0"
}

stages {
    stage('Clone') {
        steps {
                git url: 'http://localhost:3000/demouser/Capstone.git'
            }
        }
            
    stage('Build + SonarQube analysis'){
        steps{
            echo 'Check code quality and Test the Build'

            withSonarQubeEnv('sonarqube') {

                    sh "mvn clean install sonar:sonar -Dsonar.login=admin -Dsonar.password=password"
                }
            }
        }
        
    stage ('Deploy artifacts to artifactory') {
        steps{
			script{
			def server = Artifactory.server 'jfrog'
			def uploadSpec = """{
				"files": [{
					"pattern": "*.war",
					"target": "quizapp"
					}]
				}"""
			server.upload(uploadSpec)
			}
		  }       
        }

    stage('Invoking CD Part'){
        steps{
            build job: 'Capstone-CD'
            }
        }
    }
    
post {
    failure {
        emailext body: '${BUILD_LOG}', subject: 'Build Failed', to: 'tanmesh59@gmail.com'
        }
    }
}
