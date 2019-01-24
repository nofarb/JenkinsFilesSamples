pipeline{
    agent any

       stages {
       
        stage('DEV') {
       
            steps {
                echo 'App deployed to DEV'
            }
        }
        stage('QA') {
            steps {
                echo 'App deployed to QA'
            }
        }

        stage('PROD') {
            options{
                timeout(time: 1, unit: 'HOURS')  //if user input not given in 1 hour stage will fail. not mandatory to set TO
            }   
            when{
                environment name: 'SHOULD_PROMOTE', value: 'YES' //Execute stage if value of "SHOULD_PROMOTE" is "YES"
            }
         
            input { //propmt the user for value for "SHOULD_PROMOTE" parameter
                message "Should we promote to PROD?"
                ok "submit patameter value"
                parameters {
                    string(name: 'SHOULD_PROMOTE', defaultValue: 'NO', description: 'Should we promote build to PRODUCTION? YES/NO')
                }
            }
            steps { 
                echo 'App deployed to PROD'

            }
        }
    }
}
