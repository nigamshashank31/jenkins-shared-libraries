def call(String project, String imageTag, String dockerHubUser){
  echo 'Pushing Docker image to Docker Hub'
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUserCred')]) {
      sh "echo ${dockerHubPass} | docker login -u ${dockerHubUserCred} --password-stdin"
  }
  def fullImageName = "${dockerHubUser}/${project}:${imageTag}"
  
  //Tag the image
  
  sh "docker image tag ${project} ${fullImageName}"

  //Push the image
  sh "docker push ${fullImageName}"
}

