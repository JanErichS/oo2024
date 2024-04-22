package ee.tlu.viimane_kodutoo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaintingData {
    public int objectID;
    public boolean isHighlight;
    public String accessionNumber;
    public String accessionYear;
    public boolean isPublicDomain;
    public String primaryImage;
    public String primaryImageSmall;
    public ArrayList<Object> additionalImages;
    public ArrayList<Constituent> constituents;
    public String department;
    public String objectName;
    public String title;
    public String culture;
    public String period;
    public String dynasty;
    public String reign;
    public String portfolio;
    public String artistRole;
    public String artistPrefix;
    public String artistDisplayName;
    public String artistDisplayBio;
    public String artistSuffix;
    public String artistAlphaSort;
    public String artistNationality;
    public String artistBeginDate;
    public String artistEndDate;
    public String artistGender;
    public String artistWikidata_URL;
    public String artistULAN_URL;
    public String objectDate;
    public int objectBeginDate;
    public int objectEndDate;
    public String medium;
    public String dimensions;
    public ArrayList<Measurement> measurements;
    public String creditLine;
    public String geographyType;
    public String city;
    public String state;
    public String county;
    public String country;
    public String region;
    public String subregion;
    public String locale;
    public String locus;
    public String excavation;
    public String river;
    public String classification;
    public String rightsAndReproduction;
    public String linkResource;
    public Date metadataDate;
    public String repository;
    public String objectURL;
    public Object tags;
    public String objectWikidata_URL;
    public boolean isTimelineWork;
    @JsonProperty("GalleryNumber")
    public String galleryNumber;
}
