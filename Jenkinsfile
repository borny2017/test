node {
    stage 'checkout'
    echo 'Checking out source code'
    git url: 'https://github.com/borny2017/test'
    stage 'compile'
    echo 'compile'
      // Run the maven build
      bat 'mci_jenkins.bat'
	  
	  def userInput = input(
		  id: 'userInput', message: 'Let\'s promote?', parameters: [
		  [$class: 'TextParameterDefinition', defaultValue: 'uat', description: 'Environment', name: 'env'],
		  [$class: 'TextParameterDefinition', defaultValue: 'uat1', description: 'Target', name: 'target']
		 ])
		 echo ("Env: "+userInput['env'])
		 echo ("Target: "+userInput['target'])
 
     // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
    stage 'Deploy'
    echo 'Deploy'
} 