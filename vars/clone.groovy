def call(String url, String branch){
            echo 'Cloning repo'
            git url: "${url}, branch: "${branch}" 
            echo 'Clone done successfully'
}
