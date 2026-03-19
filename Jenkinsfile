pipeline {
    agent any
    tools {
        maven ""${params.MAVEN}""
    }

    environment {
        GITHUB_REPOSITORY= "${params.GITHUB_REPOSITORY}"
        DOCKERHUB_CREDENTIALS="${params.DOCKER_CRED}"
        DOCKERHUB_REPOSITORY="williamsayo44/localization"
        DOCKER_IMAGE_TAG="v1"
    }

    stages{
        stage('Check Java') {
            steps {
                bat 'java -version'
                bat 'echo %JAVA_HOME%'
                bat 'mvn -version'
            }
        }

        stage("check docker"){
            step{
                bat "docker -version"
            }
        }

        stage("checkout"){
            step{
                git branch: "${BRANCH}", url:"${GITHUB_REPOSITORY}"
            }
        }

        stage("test"){
            step{
                bat "mvn clean test"
            }
        }

        stage("coverage report"){
            step{
                bat "mvn jacoco:report"
            }
        }

        stage("publish test report"){
            step{
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage("publish coverage report"){
            step{
                jacoco()
            }
        }

        stage("build docker image"){
            step{
                bat "docker build -t ${DOCKERHUB_REPOSITORY}:${DOCKER_IMAGE_TAG}"
            }
        }

        stage("Push Docker Image to Docker Hub"){
            step{
                script{
                    with docker.registry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID){
                        docker.image("${DOCKERHUB_REPOSITORY}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}