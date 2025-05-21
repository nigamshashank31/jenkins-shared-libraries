def call(String url, String branch){
            echo "Cloning repo from ${url}, branch:${branch}"
            git url: url, branch:branch
            echo "Clone done successfully"
}
