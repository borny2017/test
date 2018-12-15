node {
    stage 'checkout'
    echo 'Checking out source code'
    git url: 'https://github.com/borny2017/test'
    stage 'compile'
    echo 'compile'
      // Run the maven build
      bat 'mci_jenkins.bat'
 
     // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
    stage 'Deploy'
    echo 'Deploy'
} 