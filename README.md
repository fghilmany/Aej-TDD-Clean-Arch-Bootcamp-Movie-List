# BDD Specs
## AEJ Case Study
## Watch List Feature Specs

### Story: User requests to see watch list movie

### Narative #1
``` 
As a online user
I want the app to automatically load the watch list movies
So I can see the watch list movies
 ```
### Scenarios #1
``` 
Given the user has connectivity
When the user requests to see the watch list movies
Then the app should display the watch list movies from remote
```

### UX goals for the watch list movies UI experience:
- [x] Load watch list automatically when view is presented
- [x] Show a loading indicator when watch list load automatically(you can use shimmer or something else)
- [x] Show a empty state when watch list data is empty and add button to retry mechanism
- [x] Render all loaded watch list items (image, title)
- [x] Show a network error state when app doesn’t have connectivity
- [x] Allow user to manually retry mechanism when doesn’t have connectivity
- [x] Allow user to manually reload watch list (swipe to refresh)

## Model Spec

## Discover Movie

#### Movie
| Property           | Type           |
|--------------------|----------------|
| `page`             | `String`       |
| `results`          | `Array Object` |
| `total_pages`      | `Long`         |
| `total_results`    | `Long`         |

#### Results
| Property            | Type      |
|---------------------|-----------|
| `adult`             | `Boolean` |
| `backdrop_path`     | `String`  |
| `genre_ids`         | `Array`   |
| `id`                | `Long`    |
| `original_language` | `String`  |
| `original_title`    | `String`  |
| `overview`          | `String`  |
| `popularity`        | `Double`  |
| `poster_path`       | `String`  |
| `release_date`      | `String`  |
| `title`             | `String`  |
| `video`             | `Boolean` |
| `vote_average`      | `Float`   |
| `vote_count`        | `Long`    |


### Api Contract
```
GET 
discover/movie

Header
Authorization: token

200 Response

{
  "page": 1,
  "results": [
    {
      "adult": false,
      "backdrop_path": "/gMJngTNfaqCSCqGD4y8lVMZXKDn.jpg",
      "genre_ids": [
        28,
        12,
        878
      ],
      "id": 640146,
      "original_language": "en",
      "original_title": "Ant-Man and the Wasp: Quantumania",
      "overview": "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
      "popularity": 8567.865,
      "poster_path": "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
      "release_date": "2023-02-15",
      "title": "Ant-Man and the Wasp: Quantumania",
      "video": false,
      "vote_average": 6.5,
      "vote_count": 1886
    }
  ],
  "total_pages": 38029,
  "total_results": 760569
}

```