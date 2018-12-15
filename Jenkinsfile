node{
  stage ('Build') {
 
    git url: 'https://github.com/borny2017/test'
 
    withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'apache-maven-3.5.4',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        //mavenSettingsConfig: 'my-maven-settings',
        mavenLocalRepo: '.repository') {
 
      // Run the maven build
      bat "mci_jenkins.bat"
 
    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
  }
}