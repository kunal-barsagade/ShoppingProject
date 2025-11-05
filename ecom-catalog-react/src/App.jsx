import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {

  const [products, setProducts] = useState([]);

  //js 
  useEffect(()=>{
  fetch('http://localhost:8081/api/products') // useing fetch to do api call to backend
    .then(response => response.json()) // getting response in json
    .then(data => setProducts(data));
},[]);

  return (
    <dev className='container'>
      <dev>
        {products.length ? (
          //Display products
          <ProductList products={products}/>
          ) : (
            <p>No products found</p>
          )}
      </dev>

    </dev>
  )
}

export default App
