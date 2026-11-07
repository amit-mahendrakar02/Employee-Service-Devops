pipeline{
    agent any
    
    # Define pipeline options
    options{
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 20, unit: 'Minutes')
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '5'))  
    }

    # Define environment variables
    environment{
        APP_NAME = "employee-service"
    }

    # Define pipeline stages
    stages{
        stage("Checkout"){
            steps{
                echo "======== Checkout Source Code ========"
                checkout scm
            }
            
            stage("Environment Check"){
                steps{
                   sh '''
                        echo "======== Environment Check ========"
                        java -version
                        mvn -version
                   '''
                }
            }
            stage("Build"){
                steps{
                    echo "======== Build the java Application ========"
                    sh "mvn clean package -DskipTests"
                }
            }
            stage("unit Test"){
                steps{
                    echo "======== Run Unit Tests ========"
                    sh "mvn test"              
                }  
            }

            
        }
    }
    post{
        always{
            echo "======== Build Completed ========"
        }
        failure{
            echo "======== Build Failed - Check Jenkins Logs ========"
        }
        always{
            cleanWs()
        }

    }
}