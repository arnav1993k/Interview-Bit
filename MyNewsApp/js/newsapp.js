var newsWire_respMsg=null;
var search_respMsg=null;
var movie_respMsg=null;
var trending_respMsg=null;
var newsArguments="all";
var location_response="New York";
var offset=0;
var lat=41;
var lng=-74;
var city="New York";
var location_tracker=0;
//functions for tracking the location
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(setPosition);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function setPosition(position) {
   lat=position.coords.latitude; 
    lng=position.coords.longitude;
    getCity();
}
//function to call google maps api to get the current city
function getCity(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      location_response= xhttp.responseText;
      getPresentCity();
    }
  };
  xhttp.open("GET","https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&result_type=administrative_area_level_2&key=AIzaSyA-1AHb2FYo2j_v8lg4oWWLhHYzlh1fo_U", true);
  xhttp.send();
}

function getPresentCity(){
    if (location_response.length>0) {
        //code
    var mapJSON=JSON.parse(location_response);
    if (mapJSON.status=="OK") {
        //code
    city=mapJSON.results[0].formatted_address.split(",")[0];
    document.getElementById("city").innerText=city;
    }
    }
}

document.getElementById("city").innerText=city;


//functions for adding news to blotter
function addnews(){
    var response=JSON.parse(newsWire_respMsg);
    var results=response.results;
    var i=0;
    var table=document.getElementById("NewsFeed");
        //table.innerHTML="";
    for(;i<results.length;i++){
        var row=table.insertRow(-1);
        var news_item=row.insertCell(0);
        news_item.style="border-style:solid; border-width:thick; border-color:gray padding:1%";
        var inhtm='<div class="news-header"><a href="'+results[i].url+'"><p style="color:#F9FEFF;margin: 0; font-weight:bold">'+results[i].title+'</p></a></div>';
        inhtm+='<div class="news-content">';
       if (results[i].multimedia[0]!=null) {
        inhtm+='<div name="imagecontainer" class="news-img-container" style="padding: 5px;margin: 10px;height:75px; width: 75px;float: left;">';
        inhtm+='<img src="'+results[i].multimedia[0].url+'"style="height:100%; width: 100%;" >';
         inhtm+='</div>';
       }
       
        inhtm+='<p style="margin:0; float: initial;">'+results[i].abstract+'</p></div>';
        news_item.innerHTML=inhtm;
        //news_item.addEventListener("click",window.open(results[i].url,"Article"));
        row=table.insertRow(-1);
        var space_item=row.insertCell(0);
        space_item.style="padding:1%;";
        //space_item.innerHTML="&nbsp;";
    }
}
//function to get selected values from the select box
function getSelectValues(select) {
  var result = [];
  var options = select && select.options;
  var opt;

  for (var i=0, iLen=options.length; i<iLen; i++) {
    opt = options[i];

    if (opt.selected) {
      result.push(opt.value || opt.text);
    }
  }
  return result;
}
//function to get filtered news items
function filternews(){
    var id="newsfilter";
    var selectbox=document.getElementById(id);
    var selected=getSelectValues(selectbox);
    newsArguments="";
    offset=0;
    for (var i=0;i<selected.length;i++) {
        //code
        newsArguments+=selected[i]+";"
    }
   
    newsArguments=newsArguments.substring(0,newsArguments.length-1);
     if (newsArguments.indexOf("all")!=-1|| newsArguments=="") {
        //code
        newsArguments="all";
    }
    var table=document.getElementById("NewsFeed");
    table.innerHTML="";
    getMore(offset);
}

//function to call the api for news
function getMore(offset){
     var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      newsWire_respMsg= xhttp.responseText;
      addnews();
    }
  };
  xhttp.open("GET","http://api.nytimes.com/svc/news/v3/content/all/"+newsArguments+"/.json?offset="+offset+"&api-key=ba3a4fa6eeecc42acb15786875c6f0cc:19:74981125", true);
  xhttp.send();
}


//function to load more news on end of scroll
/*document.getElementById("news-table-div").addEventListener('scroll',function()
                              {
                                if($(this).scrollTop() + $(this).innerHeight()>=$(this)[0].scrollHeight)
                                {
                                  getMore(document.getElementById("NewsFeed").children[0].children.length);
                                }
                              });*/
$("#news-table-div").bind('scroll', function()
                              {
                                if($(this).scrollTop() + $(this).innerHeight()>=$(this)[0].scrollHeight)
                                {
                                  getMore(document.getElementById("NewsFeed").children[0].children.length);
                                }
                              })
function loadMovie(){
    var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      movie_respMsg= xhttp.responseText;
      addMovies(movie_respMsg);
    }
  };
  xhttp.open("GET","http://api.nytimes.com/svc/movies/v2/reviews/search.json?api-key=adb817c50f2ebd225ba0c67dcbe3fbf9:17:74981125", true);
  xhttp.send();
}
//function to add movies to the blotter
function addMovies(){
    var response=JSON.parse(movie_respMsg);
    var results=response.results;
    var i=0;
    var table=document.getElementById("MovieReviews");
        table.innerHTML="";
    for(;i<results.length;i++){
        var row=table.insertRow(-1);
        var movie_item=row.insertCell(0);
        movie_item.style="border-style:solid; border-width:thick; border-color:gray padding:1%";
        var inhtm='<div class="news-header"><a href="'+results[i].link.url+'" data-toggle="tooltip" data-placement="left" title="'+results[i].headline+'"><p style="color:rgb(255,255,255); font-weight:bold">'+results[i].display_title+'</p>';
        inhtm+='<p class="ratings-pill"> Ratings : '+results[i].critics_pick+'</p></a></div>';
        inhtm+='<div class="review-content">';
       
       if (results[i].multimedia!=null) {
        //code
        inhtm+='<div name="imagecontainer" class="movie-img-container" style="padding:2px;margin: 10px;height:75px; width: 75px;float: left;">';
        inhtm+='<img src="'+results[i].multimedia.src+'" style="width:100%; height:100%">';
        inhtm+='</div>';
       }
        
        inhtm+='<p style="margin:0; float: initial; color: #370961;">'+results[i].summary_short+'</p></div>';
        movie_item.innerHTML=inhtm;
        row=table.insertRow(-1);
        var space_item=row.insertCell(0);
        space_item.style="padding:1%;";
    }
}
//to show details of movies on hovering over movie name

 

//encoding to values for search api
function encodeComponent(str){
    str=str.replace('"','%22');
    str=str.replace('"','%22');
    str=str.replace(' ','+');
    str=str.replace(':','%3A');
    str=str.replace('(','%28');
    str=str.replace(')','%29');
    return str;
}
//function to search articles
function searchNews(query){
     var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      search_respMsg= xhttp.responseText;
      //addnews(search_respMsg);
    }
  };
  var fq=null;
  if (location_tracker==1) {
    //code
  fq='glocations:("'+city+'")';
  query=encodeURIComponent(query);
  fq=encodeComponent(fq);
  fq="&fq="+fq+"&";
  }
  else{
    fq="&";
  }
  xhttp.open("GET","http://api.nytimes.com/svc/search/v2/articlesearch.json?q="+query+fq+"api-key=d84ce113687b586f5252dac90e321781:9:74981125", true);
  xhttp.send();
    
}

$('#search').keyup(function(){
            var searchField = $('#search').val();
            var regex = new RegExp(searchField, "i");
            var output = "<table>";
            var count = 1;
            if (searchField.length>0) {
                //code
            
            searchNews(searchField);
            var results=JSON.parse(search_respMsg);
            if (results!=null && results.response!=null && results.response.docs!=null) {
                //code
                    results=results.response.docs;
                    for(var i=0;i<results.length;i++){
                        var headline=results[i].headline.main;
                        var description=results[i].snippet;
                        var url=results[i].web_url;
                        if (description==null) {
                            description=" ";
                        }
                        output+='<tr><td style="padding: 10px 5px 10px 5px;">'+'<a href="'+url+'"><h5 style="margin:1px; font-weight:bold; color=rgb(1, 124, 255)">'+headline+'</h5></a><p style="color:rgb(39, 255, 1);margin:1px;">'+url+
                        '</p><p style="color:#CACACA; margin:1px;width:50%">'+description+"</p></td></tr>";
                    }
                    document.getElementById("searchResults").innerHTML="";
                    document.getElementById("searchResults").innerHTML=output;
                    document.getElementById("searchResults").style.display="block";
                    document.getElementById("searchResults-div").style.display="block";
                }
            }
            else{
                document.getElementById("searchResults").innerHTML="";
                //document.getElementById("searchResults").style.display="none";
                document.getElementById("searchResults-div").style.display="none";
            }
        }); 
function toggle_location(element){
    if (location_tracker==0) {
        element.style.color="red";
        location_tracker=1;
        getLocation();
    }
    else{
        element.style.color="white";
        location_tracker=0;
    }
}
function loadTrending() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
        trending_respMsg= xhttp.responseText;
        addTrending();
        }
    };
  xhttp.open("GET","http://api.nytimes.com/svc/mostpopular/v2/mostviewed/world/1.json?api-key=340a3bada48a999d73aea77d50512639:3:74981125", true);
  xhttp.send();
    
}
function addTrending(){
    var response=JSON.parse(trending_respMsg);
    var results=response.results;
    var list=document.getElementById("trending-div");
    var dataContainer=document.getElementById("trending-div-data");
    for(var i=0;i<Math.min(5,results.length);i++){
        var node=document.createElement("LI");
        node.setAttribute("data-target","#myCarousel");
        node.setAttribute("data-slide-to",i);
        if (i==0) {
            node.setAttribute("class","active");
        }
        list.appendChild(node);
    }
    for(var i=0;i<Math.min(5,results.length);i++){
        var dataDiv=document.createElement("DIV");
        if (i==0) {
            dataDiv.setAttribute("class","item active");
        }
        else{
            dataDiv.setAttribute("class","item");
        }
        var inhtm="";
        
        if (results[i].media[0].type=="image") {
            inhtm+='<div class="trending-img-container">';
            inhtm+='<img src="'+results[i].media[0]["media-metadata"][0].url+'" style="width:100%; height:100%"></div>';
        }
        inhtm+='<h4>'+results[i].title+'<br><span style="font-style:normal; font-size:12px">'+results[i].byline+'</span></h4>';
        dataDiv.innerHTML=inhtm;
        dataContainer.appendChild(dataDiv);
    }
    
    
    
}
function loadApp(){ 
    document.getElementById("city").innerText=city;
    loadMovie();
    getMore(offset);
    loadTrending();
    $('[data-toggle="tooltip"]').tooltip();  
}
$(window).load(function(){
 $(document).ready(function() {
    
       $('#newsfilter').multiselect({ 
           enableFiltering:true ,
           numberDisplayed: 1
});
 });
 
loadApp();
});
