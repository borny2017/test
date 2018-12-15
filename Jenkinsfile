node {
    stage 'checkout'
    echo 'Checking out source code'
    git url: 'https://github.com/borny2017/test'
    stage 'compile'
    echo "compile"
    sh "${mvnHome}/bin/mvn compile"
    stage 'test'
    echo "Test"
    // sh "${mvnHome}/bin/mvn test"
    stage 'User Acceptance'
    timeout(time: 30, unit: 'SECONDS') {
        input 'Alles Ok'
    }
    stage 'Deploy'
    echo 'Deploy'
}
