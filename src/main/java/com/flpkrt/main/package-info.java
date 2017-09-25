@FetchProfiles(value = {@FetchProfile(name= Item.ITEM_JOIN,
        fetchOverrides = @FetchProfile.FetchOverride(mode = FetchMode.JOIN ,entity =Item.class,association = "bids"))})
package com.flpkrt.main;

import com.flpkrt.entity.Item;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;

