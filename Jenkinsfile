node {
    stage 'checkout'
    echo 'Checking out source code'
    git url: 'https://github.com/borny2017/test'
    stage 'compile'
    echo "compile"
	 withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'M3',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        //mavenSettingsConfig: 'my-maven-settings',
        //mavenLocalRepo: '.repository'
		) {
 
      // Run the maven build
      bat "mci_jenkins.bat"
 
    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
    
	
	def userInput = input(
		id: 'userInput', message: 'Let\'s promote?', parameters: [
		[$class: 'TextParameterDefinition', defaultValue: 'uat', description: 'Environment', name: 'env'],
		[$class: 'TextParameterDefinition', defaultValue: 'uat1', description: 'Target', name: 'target']
	   ])
	   echo ("Env: "+userInput['env'])
	   echo ("Target: "+userInput['target'])
	
	stage 'Deploy'
    echo 'Deploy'
}
