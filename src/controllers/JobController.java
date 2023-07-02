package controllers;

import models.*;
import java.util.ArrayList;

/**
 * Representa o controlador dos empregos disponíveis em cada empresa.
 * <p>
 * Contém métodos para atualização, criação e gerenciamentos destes.
 * @author Ana, Arthur e Caio
 * @version 1.2
 * @since 2023
 */
public class JobController {
    private final static String[] modalities = {"Presencial", "Hibrido", "Remoto"};
    
    /**
     * Cria um objeto do tipo <code>Job</code> com os parâmetros pré-definidos.
     * @param name o nome do emprego
     * @param occupationArea a área de ocupação do emprego
     * @param salary o salário do emprego
     * @param modality a modalidade do emprego
     * @param workload a carga horária do emprego
     * @param requirements os requerimentos do emprego
     * @return o emprego, <code>Job</code>
     */
    public Job createJob(String name, String occupationArea, int salary, String modality, int workload, String requirements) {
        return new Job(name, salary, workload, modality, occupationArea, requirements);
    }

    /**
     * Cria um objeto do tipo <code>Job</code> com os parâmetros pré-definidos.
     * @param name o nome do emprego
     * @param occupationArea a área de ocupação do emprego
     * @param salary o salário do emprego
     * @param modality a modalidade do emprego
     * @param workload a carga horária do emprego
     * @return o emprego, <code>Job</code>
     */
    public Job createJob(String name, String occupationArea, int salary, String modality, int workload) {
        return new Job(name, salary, workload, modality, occupationArea);
    }

    /**
     * Retorna uma lista com as modalidades válidas assinaladas para um <code>Job</code>.
     * @return uma lista, <code>String[]</code>
     */
    public static String[] getModalities() {
        return modalities;
    }

    /**
     * Retorna uma lista (no formato HTML) de acordo com os atributos do(s) <code>Job</code>(s) de uma lista pré-definida de <code>Company</code>.
     * @param companies as empresas a serem listadas
     * @return uma lista de <code>String</code> no formato HTML, <code>ArrayList&lt;String&gt;</code>
     */
    public ArrayList<String> getJobsList(ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            for(Job job : company.getJobs()) {
                jobList.add(formatJobToHTML(company, job));
            }
        }

        return jobList;
    }

    /**
     * Retorna uma <code>String</code> formatada em HTML de acordo com os parâmetros de <code>Company</code> e <code>Job</code>.
     * @param company a empresa a ser referenciada
     * @param job o emprego a ser referenciado
     * @return uma <code>String</code> formatada em HTML, <code>String</code>
     */
    private String formatJobToHTML(Company company, Job job) {
        return "<html><body>" + "Nome da vaga: " + job.getName()
                + "<br>Nome da empresa: " + company.getName()
                + "<br>Representante: " + company.getRepresentative()
                + "<br>Modalidade: " + job.getModality()
                + "<br>Área de Ocupação: " + job.getOccupationArea()
                + "<br> </body></html>";
    }

    /**
     * Retorna uma lista (no formato HTML) de acordo com os atributos do(s) <code>Job</code>(s) de uma lista pré-definida de <code>Company</code>.
     * Um <code>Job</code> só será mostrado caso o parâmetro <code>jobName</code> esteja contido no nome do objeto <code>Job</code>
     * @param jobName o nome do emprego a ser procurado
     * @param companies as empresas a serem listadas e filtradas
     * @return uma lista de <code>String</code> no formato HTML, <code>ArrayList&lt;String&gt;</code>
     */
    public ArrayList<String> filterJobsByName(String jobName, ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            for(Job job : company.getJobs()) {
                if(!job.getName().toLowerCase().contains(jobName.toLowerCase()))
                    continue;

                jobList.add(formatJobToHTML(company, job));
            }
        }

        return jobList;
    }

    /**
     * Retorna o objeto <code>Job</code> de uma <code>Company</code> de acordo com o parâmetro <code>jobName</code> (nome do emprego).
     * <p>
     * Caso não exista um objeto referenciado com esta chave, o retorno será <code>null</code>.
     * @param company a empresa a ser referenciada
     * @param jobName o nome do emprego a ser procurado
     * @return o emprego, <code>Job</code>
     */
    public Job getJobByName(Company company, String jobName) {
        for(Job job : company.getJobs()) {
            if(job.getName().equals(jobName)) {
                return job;
            }
        }

        return null;
    }

    /**
     * Transforma uma <code>String</code> em um <code>int</code> e decide se é válido ou não.
     * Caso não seja válido, o valor retornado será <code>-1</code>.
     * É semelhante ao método <code>getValidWorkload</code>, mas é específico para determinar validade de um salário.
     * Caso haja mudanças significativas entre os dois métodos, já está tudo devidamente separado.
     * @param salarystr a <code>String</code> a ser transformada em <code>int</code>
     * @return <code>int</code>
     */
    public static int getValidSalary(String salarystr) {
        int salary = -1;

        if(salarystr.matches("[0-9]+"))
            salary = Integer.parseInt(salarystr);

        if(salary < 0)
            return -1;

        return salary;
    }

    /**
     * Transforma uma <code>String</code> em um <code>int</code> e decide se é válido ou não.
     * Caso não seja válido, o valor retornado será <code>-1</code>.
     * É semelhante ao método <code>getValidSalary</code>, mas é específico para determinar validade de uma carga de trabalho.
     * Caso haja mudanças significativas entre os dois métodos, já está tudo devidamente separado.
     * @param workloadstr a <code>String</code> a ser transformada em <code>int</code>
     * @return <code>int</code>
     */
    public static int getValidWorkload(String workloadstr) {
        int workload = -1;

        if(workloadstr.matches("[0-9]+"))
            workload = Integer.parseInt(workloadstr);

        if(workload < 0)
            return -1;

        return workload;
    }
    
    /**
     * Deleta o objeto do tipo <code>Job</code> referenciado no objeto do tipo <code>Company</code>.
     * @param job o emprego a ser deletado
     * @param company a empresa a ser referenciada
     */
    public void deleteJob(Job job, Company company) {
    	company.removeJob(job);
    }
    
    /**
     * Atualiza o nome do emprego, caso haja alteração no nome.
     * @param job o emprego a ser atualizado
     * @param name o novo nome do emprego
     */
    public void updateName(Job job, String name) {
        if(!job.getName().equals(name)) {
            job.setName(name);
        }
    }

    /**
     * Atualiza a área de ocupação do emprego, caso haja alteração na área de ocupação.
     * @param job o emprego a ser atualizado
     * @param occupationArea a nova área de ocupação do emprego
     */
    public void updateOccupationArea(Job job, String occupationArea) {
    	if(!job.getOccupationArea().equals(occupationArea)) {
    		job.setOccupationArea(occupationArea);
    	}
    }
    
    /**
     * Atualiza o salário do emprego, caso haja alteração no salário.
     * @param job o emprego a ser atualizado
     * @param salary o novo salário do emprego
     */
    public void updateSalary(Job job, int salary) {
    	if(job.getSalary() != salary) {
    		job.setSalary(salary);
    	}
    }
    
    /**
     * Atualiza a carga horária do emprego, caso haja alteração na carga horária.
     * @param job o emprego a ser atualizado
     * @param workload a nova carga horária do emprego
     */
    public void updateWorkload(Job job, int workload) {
    	if(job.getWorkload() != workload) {
    		job.setWorkload(workload);
    	}
    }
    
    /**
     * Atualiza a modalidade do emprego, caso haja alteração na modalidade.
     * @param job o emprego a ser atualizado
     * @param modality a nova modalidade do emprego
     */
    public void updateModality(Job job, String modality) {
    	if(!job.getModality().equals(modality)) {
    		job.setModality(modality);
    	}
    }
    
    /**
     * Atualiza os requerimentos do emprego, caso haja alteração nos requerimentos.
     * @param job o emprego a ser atualizado
     * @param requirements os novos requerimentos do emprego
     */
    public void updateRequirements(Job job, String requirements) {
    	if(!job.getRequirements().equals(requirements)) {
    		job.setRequirements(requirements);
    	}
    }
}