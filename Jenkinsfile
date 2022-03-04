pipeline {
	agent any

	environment {
		MUDI_ACCESSKEY = credentials('github-pessoal-romulo')
	}

	stages {
		stage('Docker Start') {
			steps {
				step([$class: 'DockerComposeBuilder', option: [$class: 'StartAllServices']])
			}
		}
		stage('Build') {
			steps {
				git credentialsId: 'github-pessoal-romulo', url: 'https://github.com/romulomf/mudi.git'
				withMaven {
					sh 'mvn clean verify'
				}
			}
		}
		stage('Docker Stop') {
			steps {
				step([$class: 'DockerComposeBuilder', option: [$class: 'StopAllServices']])
			}
		}
	}
}