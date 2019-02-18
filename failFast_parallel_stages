pipeline {
    agent any
    stages {
        stage('Non-Parallel Stage') {
            steps {
                echo 'This stage will be executed first.'
            }
        }
        stage('Parallel Stage') {

            failFast true
            parallel {
                stage('Branch A') {

                    steps {
                        sh exit -1
                    }
                }
                stage('Branch B') {

                    steps {
                        sleep 10
                        echo "On Branch B"
                    }
                }
                stage('Branch C') {

                    stages {
                        stage('Nested 1') {
                            steps {
                                sleep 10
                                echo "In stage Nested 1 within Branch C"
                            }
                        }
                        stage('Nested 2') {
                            steps {
                                sleep 10
                                echo "In stage Nested 2 within Branch C"
                            }
                        }
                    }
                }
            }

            post { 
                always { 
                    echo 'I will always say Hello again!'
                }
            }
        }
  
    }
}
