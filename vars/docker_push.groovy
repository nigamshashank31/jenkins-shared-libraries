def call(String Project, String ImageTag, String dockerhubuser){
  echo 'Pushing Docker image to Docker Hub'
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh """docker image tag django_app $dockerHubUser/django_app"""
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}

