<template>

    <v-data-table
        :headers="headers"
        :items="getDelivery"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GetDeliveryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            getDelivery : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/getDeliveries'))

            temp.data._embedded.getDeliveries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.getDelivery = temp.data._embedded.getDeliveries;
        },
        methods: {
        }
    }
</script>

