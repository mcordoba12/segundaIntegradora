package model;

public class Capsule {
    private String id;
	private String description;
    private CapsuleType type;
    private String learnedLessons;
    private String nameCol;
    private String cargoCol;
    private boolean aproved = false;
    private Date aprobDate;
    private String hashtag;
    private String url;
    private boolean published = false;


    public Capsule(String id, String description, CapsuleType type, String learnedLessons, String nameCol,
            String cargoCol) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.learnedLessons = learnedLessons;
        this.nameCol = nameCol;
        this.cargoCol = cargoCol;
        this.aproved = aproved;
        this.aprobDate = aprobDate;
        this.published = published;
        this.url="";
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
	public String getNameCol() {
        return nameCol;
    }


    public void setNameCol(String nameCol) {
        this.nameCol = nameCol;
    }


    public String getCargoCol() {
        return cargoCol;
    }


    public void setCargoCol(String cargoCol) {
        this.cargoCol = cargoCol;
    }


	public String getLearnedLessons() {
		return learnedLessons;
	}


	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

    public CapsuleType getType() {
        return type;
    }

    public void setType(CapsuleType type) {
        this.type = type;
    }

    public boolean isAproved() {
        return aproved;
    }

    public void setAproved(boolean aproved) {
        this.aproved = aproved;
    }

    public Date getAprobDate() {
        return aprobDate;
    }


    public void setAprobDate(Date aprobDate) {
        this.aprobDate = aprobDate;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

}
