package controllers;

import models.*;
import java.util.ArrayList;

public class JobController {
    private final static String[] modalities = {"Presencial", "Hibrido", "Remoto"};
    
    public static String[] getModalities() {
        return modalities;
    }

    public Job createJob(String name, String occupationArea, int salary, String modality, int workload, String requirements) {
        Job job = new Job(name, salary, workload, modality, occupationArea, requirements);

        return job;
    }

    public Job createJob(String name, String occupationArea, int salary, String modality, int workload) {
        return new Job(name, salary, workload, modality, occupationArea);
    }

    public ArrayList<String> getJobsList(ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            for(Job job : company.getJobs()) {
                jobList.add(formatJobToHTML(company, job));
            }
        }

        return jobList;
    }

    private String formatJobToHTML(Company company, Job job) {
        return "<html><body>" + "Nome da vaga: " + job.getName()
                + "<br>Nome da empresa: " + company.getName()
                + "<br>Representante: " + company.getRepresentant()
                + "<br>Modalidade: " + job.getModality()
                + "<br>Área de Ocupação: " + job.getOccupationArea()
                + "<br> </body></html>";
    }

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

    public ArrayList<String> listCompaniesJob(ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            for(Job job : company.getJobs()) {
                jobList.add(formatJobToHTML(company, job));
            }
        }

        return jobList;
    }

    public Job getJobByName(Company company, String jobName) {
        for(Job job : company.getJobs()) {
            if(job.getName().equals(jobName)) {
                return job;
            }
        }

        return null;
    }

    public static int getValidSalary(String salarystr) {
        int salary = -1;

        if(salarystr.matches("[0-9]+"))
            salary = Integer.parseInt(salarystr);

        if(salary < 0)
            return -1;

        return salary;
    }

    public static int getValidWorkload(String workloadstr) {
        int workload = -1;

        if(workloadstr.matches("[0-9]+"))
            workload = Integer.parseInt(workloadstr);

        if(workload < 0)
            return -1;

        return workload;
    }
}
