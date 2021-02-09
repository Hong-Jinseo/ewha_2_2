//Lab Ex3) Sorting an array

function sort(arr){
    var temp;
    for(var i=0; i<arr.length; i++) {
      for(var j=0; j<arr.length-i-1; j++) {
        if(arr[j]> arr[j+1]) {
          temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }  
    return arr;
  }
  
  console.log(sort([]));
  console.log(sort([5]));
  console.log(sort([4,1]));
  console.log(sort([3,2,3]));
  console.log(sort([5,3,8,9,4,1]));