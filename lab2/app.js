// single state store
class Store {
    constructor (storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        // these are the key name you can use in Store
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems () {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems (cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue () {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue (queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods () {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods (foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items = this.store.cartItems;
        this.init();
    }

    init () {
        // Render a list of items under root element
        this.render();
        // TODO: attach remove cart items to rendered HTML
        
        // Remove buttons located in removeItem(item) function. Creation of click EventListener calling removeItem(item) is found in RemoveButton class.
    }

    destroy () {
        // TODO: remove all the events attached from init
        // Destroying of click EventListener is found in RemoveButton class.
    }

    // remove an item from shopping cart
    removeItem (item) {
     
        if (this.items != null) {
            var updated_list = [];
            var to_compare = item[0];
            for (var i = 0; i < this.items.length; i++) {
                if (this.items[i][0] != to_compare) {
                    updated_list.push(this.items[i]);
                }
            }
            this.store.cartItems = updated_list;
            this.items = updated_list;
        }
        this.render();
    }

    removeAllItems() {
        this.store.cartItems = [];
        this.items = [];
        this.render();
    }

    placeOrder () {
        // add item to statuses in store as status "in progress"
        console.log("Your order is ready!");
    }

    // render a list of item under root element
    render () {
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML = ``;
        if (this.items === null) {
            this.items = [];
        } else if (this.items.length == 0) {
            tbody.innerHTML +=
            `<tr class="cart-table">
            <td class="cart-table">
            <h3>Add something on the cart</h3>
            
            </td>
            </tr>`; 
            return;
        }
        for (var i = 0; i < this.items.length; i++) {
            // for each item in cartItems, create a row with the item name and image in one cell, and then a box of quantity in the other cell.
            var item_name = this.items[i][0];
            
            var item_price = Number(this.items[i][1]);
            
            tbody.innerHTML +=
            `<tr class="cart-table">
            <td class="cart-table">
            <h3>${item_name}</h3>
            
            </td>
            <td class="cart-table">
            <h3>${item_description}</h3>
            </td>
            <td class="cart-table">
            <button class="remove_button" data-name=${item_name} data-index=${i}>Remove From cart!</button>
            </td>
            </tr>`;
        }

        
        
        let removeButtons = document.querySelectorAll('.remove_button');
        for (var i = 0; i < removeButtons.length; i++) {
            let btn = removeButtons[i];
            btn.addEventListener('click', () => {
                let item = this.items[parseInt(btn.dataset.index)];
                this.removeItem(item);
            });
        }
        

        
    }
}    

class RemoveButton {
    constructor(root, store, cart) {
        this.root = root;
        this.store = store;
        this.cart = cart;
        this.onClick = () => this.cart.removeItem(this.root.dataset.name);
        this.init();
    }

    init () {
        this.root.addEventListener("click", this.onClick);
    }

    destroy () {
        this.root.removeEventListener("click", this.onClick);
    }

}

class ClearStatusButton {
    constructor(root, store, cart) {
        this.root = root;
        this.store = store;
        this.cart = cart;
        this.onClick = () => this.clearStatuses();
        this.init();
    }

    init () {
        this.root.addEventListener("click", this.onClick);
    }

    destroy () {
        this.root.removeEventListener("click", this.onClick);
    }

    clearStatuses() {
        let status = document.querySelector(".status_table");  
    }
}

class CheckoutButton {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }

    init () {
        this.root.addEventListener("click", this.onClick);
    }

    destroy () {
        this.root.removeEventListener("click", this.onClick);
    }

    addItemToCart () {
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
        // TODO: replace with actual item
        var new_cart_item = true;
        for (var i = 0; i < cartItems.length; i++) {
            // go through each item name in cartItems. If they match, increase the quantity of existing item in cartItems by 1. Otherwise, add the item as a new entry in cartItems.
            var existing_cart_item_name = cartItems[i][0]
            if (this.root.dataset.name === existing_cart_item_name) {
                var amount_to_add = (this.root.dataset.description);
                cartItems[i][1] += amount_to_add;
                new_cart_item = false;
            }
        }
        if (new_cart_item) {
            cartItems.push([this.root.dataset.name, this.root.dataset.description]);
        }
        this.store.cartItems = cartItems;
    }
}

class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init () {
        // attach click event listener to table header row on each column
        render();
    }

    destroy () {
        // remove all the events attached from init
    }

    sort (columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render () {

    }
}

// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    // let statusTable = document.querySelector('');
    // // use querySelector to find the cart element (preferably by id selector)
    let cart = document.querySelector('.cart-table');
    let checkoutButtons = document.querySelectorAll('.checkout-button');

    let store = new Store(window.localStorage);
    // if (table) {
    //     new StatusTable(table, store);
    // }
    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i ++) {
            new CheckoutButton(checkoutButtons[i], store);
        }
    }


}

);
class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
        // TODO: attach event listeners like click to remove items after rendering
        /* Event listeners added in render() function */
    }

    destroy () {
        // TODO: remove event listeners added from the init above
        let inventoryAddDefaultButton = document.querySelector('.inventory_add_default_button');
        if (inventoryAddDefaultButton) {
            inventoryAddDefaultButton.removeEventListener("click", () => {
                this.addDefaultItems();
            });
        }

        let removeInventoryButtons = document.querySelectorAll('.remove_inventory_button');
        for (var i = 0; i < removeInventoryButtons.length; i++) {
            let btn = removeInventoryButtons[i];
            btn.removeEventListener('click', () => {
                let item = this.store.foods[parseInt(btn.dataset.index)];
                this.removeItem(item);
            });
        }
    }

    removeItem (itemName) {
        // TODO: function to remove item given item name from store
        if (this.store.foods !== null) {
            var updated_list = [];
            var to_compare = itemName.name;
            for (var i = 0; i < this.store.foods.length; i++) {
                if (this.store.foods[i].name !== to_compare) {
                    updated_list.push(this.store.foods[i]);
                }
            }
            this.store.foods = updated_list;
        }
        this.render();
    }

    addDefaultItems() {
        let storeFoods = this.store.foods || [];

        var unholy_water = {name: "Unholy Water", image: "../../images/potion1.png", description: "Cursed and hexed by numerous witches, this potion has been known to induce aggression and spite in its drinkers."};
        var dragon_breath_ale = {name: "Dragon Breath Ale", image: "../../images/potion2.png", description: "Since the days of old, knights have been known to consume the scorched liquor of dragons to acquire immunity to flame."};
        var matrix_mead = {name: "Matrix Mead", image: "../../images/potion3.png", description: "What happens if you mix a blue pill and a red pill together? Only the truly brave would dare to find out..."};
        var stealth_swill = {name: "Stealth Swill", image: "../../images/potion4.png", description: "Want to spy on your mortal enemy? A swig of this swill will turn you invisible. Even the bottle itself is disappearing!"};
        var gnomish_gin = {name: "Gnomish Gin", image: "../../images/potion5.png", description: "This refreshing concoction has been imbued with secretive gnomish medicinal herbs, perfect for all your combat ailments."};
        var updated_item_list = [unholy_water, dragon_breath_ale, matrix_mead, stealth_swill, gnomish_gin];

        var is_new_liquor = true;
        for (var i = 0; i < storeFoods.length; i++) {
            var is_new_liquor = true;
            for (var j = 0; j < updated_item_list.length; j++) {
                if (storeFoods[i].name === updated_item_list[j].name) {
                    is_new_liquor = false;
                    break;
                }
            }
            if (is_new_liquor) {
                updated_item_list.push(storeFoods[i]);
            }
        }
        this.store.foods = updated_item_list;
        this.render();
    }

    render () {
        // using innerHTML to render inventory listing
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML = ``;

        // display message to add more liquor if there is no new recipes
        if (this.store.foods === null) {
            this.store.foods = [];
        } 
        // display all of the user-submitted brews
        for (var i = 0; i < this.store.foods.length; i++) {
            // for each item in local storage's FOODS, create a row with a cell for the item name and image, and one for description.
            var food_name = this.store.foods[i].name;
            var food_image = this.store.foods[i].image;
            var food_description = this.store.foods[i].description;

            tbody.innerHTML +=
                `<tr class="horizontal">
                    <td class="horizontal"><h3>${food_name}</h3>
                        <img class="small" src=${food_image}>
                    </td>
                    <td><p>${food_description}</p>
                    </td>
                    <td class="horizontal">
                        <button class="remove_inventory_button" data-index=${i}>Remove!</button>
                     </td>
                  </tr>`;
        }

        tbody.innerHTML += 
        `<tr class="horizontal">
            <td class="horizontal" colspan="3"><p>Continue brewing by clicking <a href="create-food-item.html" class="link">here</a>!</p>
                <button class="inventory_add_default_button">Restore House Specials!</button>
            </td>
        </tr>`; 

        let inventoryAddDefaultButton = document.querySelector('.inventory_add_default_button');
        if (inventoryAddDefaultButton) {
            inventoryAddDefaultButton.addEventListener("click", () => {
                this.addDefaultItems();
            });
        }

        let removeInventoryButtons = document.querySelectorAll('.remove_inventory_button');
        for (var i = 0; i < removeInventoryButtons.length; i++) {
            let btn = removeInventoryButtons[i];
            btn.addEventListener('click', () => {
                let item = this.store.foods[parseInt(btn.dataset.index)];
                this.removeItem(item);
            });
        }
    }
}

class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
    init () {
        this.render();
    }

    render () {
        // TODO: render a list of food menu from store using innerHTML
        let tbody = this.root.querySelector('tbody');

        for (var i = 0; i < this.store.foods.length; i++) {
            // for each item in local storage's FOODS, create a row with a cell for the item name and image, and one for description.
            var food_name = this.store.foods[i].name;
            var food_image = this.store.foods[i].image;
            if (food_image.startsWith("../")) {
                food_image = liquor_image.slice(3);
            }
            var food_description = this.store.foods[i].description;

            tbody.innerHTML +=
                `<tr class="horizontal">
                    <td class="horizontal menu1"><h3>${food_name}</h3></td>
                    <td class="horizontal menu2"><img class="medium" src=${food_image}>
                    </td>
                    <td class="horizontal menu3"><p>${food_description}</p>
                    </td>
                    <td class="horizontal menu4">
                        <button class="checkout-button" data-name="${food_name}" data-image="${liquor_image}" data-quantity=1>Order Drink!</button>
                     </td>
                  </tr>`;
        }

        let checkoutButtons = document.querySelectorAll('.checkout-button');
        if (checkoutButtons && checkoutButtons.length) {
            for (var i = 0; i < checkoutButtons.length; i++) {
                new CheckoutButton(checkoutButtons[i], this.store, this.cart);
            }
        }
    }
}

class CreateFood {
    constructor(root, store) {
        this.root = root; // root should be the container of the form itself
        this.store = store;
        this.init();
    }

    init () {
     // attach click event to create button
        let createLiquorButton = document.getElementById('create_liquor_button');
        if (createLiquorButton) {
            createLiquorButton.addEventListener("click", () => {
                this.createFood();
            });
        }
        document.getElementById("before_brew_message").innerHTML = 
            `<h4>Try this out!</h4>
            <strong>NAME:</strong> Healing Salve<br>
            <strong>IMAGE:</strong> ../../images/potion6.png<br>
            <strong>DESCRIPTION:</strong> Recover a morsel of HP!
            `;
    }

    createFood () {
             // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store
        let storeFoods = this.store.foods || [];
        var liquor_name = document.getElementById('food_name').value;
        var liquor_image = document.getElementById('food_image').value;
        var liquor_description = document.getElementById('food_description').value;
        var to_push = {name: food_name, image: food_image, description: food_description};

        if (window.confirm("Are you sure you want to brew this liquor?") == true) {

            // check to make sure submitted food is actually new
            var is_new_liquor = true;
            for (var i = 0; i < storeFoods.length; i++) {
                if (to_push.name === storeFoods[i].name) {
                    is_new_liquor = false;
                    break;
                }
            }
            if (is_new_liquor) {
                storeFoods.push(to_push);
                this.store.foods = storeFoods;
                document.getElementById("before_brew_message").innerHTML = ``;

                document.getElementById("added_brew_message").innerHTML = 
                `Added the following liquor:<br>
                    NAME: ${food_name}<br>
                    IMAGE LINK: ${food_image}<br>
                    DESCRIPTION: ${food_description}<br>
                    <br>
                    Click <a href="inventory.html" class="link">here</a> to check it out!
                `;
            } else {
                document.getElementById("added_brew_message").innerHTML = 
                `Liquor already exists in the inventory. Try again!`;
            }
        }
    }
}

// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    let statusTable = document.querySelector('.order_status_table');
    // // use querySelector to find the cart element (preferably by id selector)
    let cart = document.querySelector('.cart-table');
    let checkoutButtons = document.querySelectorAll('.checkout-button');

    // finding the form element to createFood
    let createFood = document.querySelector('#create_liquor_form');
    let inventory = document.querySelector('#inventory_table');
    let menu = document.querySelector('#menu_table');

    let store = new Store(window.localStorage);

    if (statusTable) {
        new StatusTable(statusTable, store);
    }
    if (cart) {
        var cartVar = new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i++) {
            new CheckoutButton(checkoutButtons[i], store, cartVar);
        }
    }

    if (createFood) {
        new CreateFood(createFood, store);
    }
    if (inventory) {
        new Inventory(inventory, store);
    }
    if (menu) {
        new Menu(menu, store, cartVar);
    }
});