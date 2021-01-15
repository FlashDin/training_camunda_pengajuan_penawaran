# training_camunda_pengajuan_penawaran #

## `urutan`

- http://localhost:8090/engine-rest/process-definition/key/prc_pengajuan_penawaran/start
```
{
  "variables": {
    "judulUsulanPenawaran" : {
        "value" : "jkl",
        "type": "String"
    },
    "namaKomoditasPenawaran" : {
      "value" : "jkl",
      "type": "String"
    },
    "namaPenyediaPenawaran" : {
      "value" : "jkl",
      "type": "String"
    },
    "emailPenawaran" : {
      "value" : "jlk@jkl.com",
      "type": "String"
    },
    "alamatPenawaran" : {
      "value" : "jkl",
      "type": "String"
    },
    "noTelpPenawaran" : {
      "value" : "085",
      "type": "String"
    },
    "statusPenawaran" : {
      "value" : "Persiapan",
      "type": "String"
    },
    "tglPengajuan" : {
      "value" : "2020-01-01",
      "type": "String"
    }
  },
 "businessKey" : "myBusinessKey"
}
```
- http://localhost:8090/engine-rest/task/{id}/submit-form
```
{
	"variables":
	    {
	    	"distributors": {
	    		"value": []
	    	
	    	},
	    	"dokumens": {
	    		"value": []
	    	},
	    	"produks": {
	    		"value": []
	    	}
	    },
        "businessKey" : "myBusinessKey"
}
```
- http://localhost:8090/engine-rest/process-instance/{id}/variables
```
{
	"modifications":
	    {
	    	"distributors": {
	    		"value": [
	    			{
	    				"idDistributor": null,
	    				"namaDistributor": "hehe",
						"npwpDistributor": "hehe",
						"emailDistributor": "hehe",
						"penawaran": {
							"idPenawaran": 5
						},
						"instanceId": "instanceId123"
	    			},
	    			{
	    				"idDistributor": null,
	    				"namaDistributor": "hehe1",
						"npwpDistributor": "hehe1",
						"emailDistributor": "hehe1",
						"penawaran": {
							"idPenawaran": 5
						},
						"instanceId": "instanceId1231"
	    			}
	    		]
	    	
	    	},
	    	"dokumens": {
	    		"value": [
	    			{
	    				"idDokumen": null,
						"pathDokumen": "hehe",
						"penawaran": {
							"idPenawaran": 5
						},
						"instanceId": "instanceId1231"
	    			},
	    			{
	    				"idDokumen": null,
						"pathDokumen": "hehe1",
						"penawaran": {
							"idPenawaran": 5
						},
						"instanceId": "instanceId1231"
	    			}
	    		]
	    	},
	    	"produks": {
	    		"value": [
	    			{
	    				"idProduk": null,
						"namaProduk": "hehe",
						"merkProduk": "hehe",
						"noProduk": "jjj",
						"hargaProduk": 101,
						"kuantitasProduk": 100,
						"penawaran": {
							"idPenawaran": 5
						},
						"instanceId": "instanceId1231"
	    			},
	    			{
	    				"idProduk": null,
						"namaProduk": "hehe",
						"merkProduk": "hehe",
						"noProduk": "jjj",
						"hargaProduk": 101,
						"kuantitasProduk": 100,
						"penawaran": {
							"idPenawaran": 5
						},
						"instanceId": "instanceId1231"
	    			}
    			]
	    	}
	    }
}
```
- ** pake satu ketika input misal distributor pake yang "distributors"
- ** get menggunakan http://localhost:8090/engine-rest/process-instance/{id}/variables
- gunakan http://localhost:8090/api/task/penawaran/all/{processInstanceId} untuk get `taskId`
- foreach taskId : http://localhost:8090/engine-rest/task/{id}/submit-form
#### `lanjut`
- http://localhost:8090/engine-rest/task/{id}/submit-form
```
{
    "variables": {
        "idPenawaran": {
            "value": 7,
            "type": "Long"
        }
    },
    "withVariablesInReturn": true
} 
```
- http://localhost:8090/engine-rest/task/{idi}/complete
```
{
    "variables": {
        "isStatusPenawaran": {
            "value": true,
            "type": "Boolean"
        }
    },
    "withVariablesInReturn": true
}
```

#### ambil data dari table generate: `penawaran`
- http://localhost:8090/api/task/penawaran/db/all
- http://localhost:8090/api/task/penawaran/db/{id}
- http://localhost:8090/api/task/penawaran/db/status
##### `parameter`
```
statusPenawaran=['Persiapan', 'Menunggu Persetujuan', 'Penawaran Diterima', 'Penawaran Ditolak']
```

### ** jika sudah melewati proses submit parallel

#### ambil data dari table generate: `distributor`
- http://localhost:8090/api/task/distributor/db/all
- http://localhost:8090/api/task/distributor/db/{id}

#### ambil data dari table generate: `dokumen`
- http://localhost:8090/api/task/dokumen/db/all
- http://localhost:8090/api/task/dokumen/db/{id}

#### ambil data dari table generate: `produk`
- http://localhost:8090/api/task/produk/db/all
- http://localhost:8090/api/task/produk/db/{id}