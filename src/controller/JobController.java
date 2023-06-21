import java.util.ArrayList;

public class JobController {
    private final static String[] modalities = {"Presencial", "Hibrido", "Remoto"};
    
    public static String[] getModalities() {
        return modalities;
    }

    public Job createJob(String name, String occupationArea, int salary, String modality, int workload, String requirements) {
        Job job = new Job(name, salary, workload, modality, occupationArea);

        for(String requirement : requirements.split(",")) {
            job.addRequirement(requirement.trim());
        }

        return job;
    }

    public Job createJob(String name, String occupationArea, int salary, String modality, int workload) {
        return new Job(name, salary, workload, modality, occupationArea);
    }

    public ArrayList<String> getJobsList(ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            for(Job job : company.getJobs()) {
                jobList.add("Nome da vaga: " + job.getName()
                + "\nNome da empresa: " + company.getName()
                + "\nRepresentante: " + company.getRepresentant()
                + "\nModalidade: " + job.getModality()
                + "\nÁrea de Ocupação: " + job.getOccupationArea());
            }
        }

        return jobList;
    }

    public ArrayList<String> filterJobsByCompany(String companyName, ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            if(!company.getName().toLowerCase().contains(companyName.toLowerCase()))
                continue;

            for(Job job : company.getJobs()) {
                jobList.add("Nome da vaga: " + job.getName()
                        + "\nNome da empresa: " + company.getName()
                        + "\nRepresentante: " + company.getRepresentant()
                        + "\nModalidade: " + job.getModality()
                        + "\nÁrea de Ocupação: " + job.getOccupationArea());
            }
        }

        return jobList;
    }

    public ArrayList<String> filterJobsByName(String jobName, ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            for(Job job : company.getJobs()) {
                if(!job.getName().toLowerCase().contains(jobName.toLowerCase()))
                    continue;

                jobList.add("Nome da vaga: " + job.getName()
                        + "\nNome da empresa: " + company.getName()
                        + "\nRepresentante: " + company.getRepresentant()
                        + "\nModalidade: " + job.getModality()
                        + "\nÁrea de Ocupação: " + job.getOccupationArea());
            }
        }

        return jobList;
    }

    public ArrayList<String> filterJobsByRegion(String region, ArrayList<Company> companies) {
        ArrayList<String> jobList = new ArrayList<>();

        for(Company company : companies) {
            if(company.getAddress().getState() != region)
                continue;

            for(Job job : company.getJobs()) {
                jobList.add("Nome da vaga: " + job.getName()
                        + "\nNome da empresa: " + company.getName()
                        + "\nRepresentante: " + company.getRepresentant()
                        + "\nModalidade: " + job.getModality()
                        + "\nÁrea de Ocupação: " + job.getOccupationArea());
            }
        }

        return jobList;
    }
}
